package sebag.florent.presentation.features.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import sebag.florent.domain.usecases.GetArtListUseCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.whenever
import sebag.florent.domain.model.ArtModel
import sebag.florent.presentation.mock.PresentationMockProvider

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Mock
    private lateinit var getArtListUseCase: GetArtListUseCase

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        homeViewModel = HomeViewModel(getArtListUseCase)
    }


    @Test
    fun `fetchArtLust success should update state to success`() = runBlockingTest {
        val mockArtList = listOf(PresentationMockProvider.artMock, PresentationMockProvider.artMock)

        whenever(getArtListUseCase(0, 15)).thenReturn(Result.success(mockArtList))

        homeViewModel.onAction(HomeAction.Retry)

        assertTrue(homeViewModel.state.value is HomeState.Success)
        val successState = homeViewModel.state.value as HomeState.Success
        assertEquals(mockArtList.size, successState.artList.size)
    }

    @Test
    fun `fetchArtList error should update state to error`() = runBlockingTest {
        val exception = Exception("Network error")
        whenever(getArtListUseCase(0, 15)).thenReturn(Result.failure(exception))

        homeViewModel.onAction(HomeAction.Retry)

        assertTrue(homeViewModel.state.value is HomeState.Error)
    }
}