package sebag.florent.presentation.features.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.usecases.GetArtDetailsUseCase
import sebag.florent.presentation.mock.PresentationMockProvider

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class DetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Mock
    private lateinit var getArtDetailsUseCase: GetArtDetailsUseCase

    private lateinit var savedStateHandle: SavedStateHandle

    private lateinit var detailsViewModel: DetailsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        savedStateHandle = SavedStateHandle(mapOf("itemId" to "1"))
        detailsViewModel = DetailsViewModel(savedStateHandle, getArtDetailsUseCase)
    }

    @Test
    fun `fetchArtDetails success should update state to success`() = runBlockingTest {
        val mockArt = PresentationMockProvider.artMock
        whenever(getArtDetailsUseCase("1")).thenReturn(Result.success(mockArt))

        detailsViewModel.onAction(DetailsAction.Retry)

        assertTrue(detailsViewModel.state.value is DetailsState.Success)
        val successState = detailsViewModel.state.value as DetailsState.Success
        assertEquals(mockArt.id, successState.art.id)
    }

    @Test
    fun `fetchArtDetails error should update state to error`() = runBlockingTest {
        whenever(getArtDetailsUseCase("1")).thenReturn(Result.failure(Exception("Network error")))

        detailsViewModel.onAction(DetailsAction.Retry)

        assertTrue(detailsViewModel.state.value is DetailsState.Error)
    }
}
