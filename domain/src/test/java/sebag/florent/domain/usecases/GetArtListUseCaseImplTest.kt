package sebag.florent.domain.usecases

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import sebag.florent.domain.mock.DomainMockProvider
import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.repositories.ArtRepository

@RunWith(MockitoJUnitRunner::class)
class GetArtListUseCaseImplTest {

    @Mock
    private lateinit var artRepository: ArtRepository

    private lateinit var useCase: GetArtListUseCase

    @Before
    fun setUp() {
        useCase = GetArtListUseCaseImpl(artRepository)
    }

    @Test
    fun `invoke should return ArtModel list when repository success`() {
        runTest {
            whenever(artRepository.getArtList(any(), any())).thenReturn(
                Result.success(DomainMockProvider.artListMock)
            )

            val result = useCase.invoke(0, 15)

            assertEquals(DomainMockProvider.artListMock, result.getOrNull())
        }
    }

    @Test
    fun `invoke should return failure when repository failure`() {
        runTest {
            val exception = mock<Exception>()

            whenever(artRepository.getArtList(any(), any()))
                .thenReturn(Result.failure(exception))

            val result = useCase.invoke(0, 15)

            assertEquals(exception, result.exceptionOrNull())
        }
    }
}