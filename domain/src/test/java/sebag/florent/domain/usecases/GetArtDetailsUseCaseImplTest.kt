package sebag.florent.domain.usecases

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
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
class GetArtDetailsUseCaseImplTest {

    @Mock
    private lateinit var artRepository: ArtRepository

    private lateinit var useCase: GetArtDetailsUseCase

    @Before
    fun setUp() {
        useCase = GetArtDetailsUseCaseImpl(artRepository)
    }

    @Test
    fun `invoke should return ArtModel when repository success`() {

        runTest {
            whenever(artRepository.getArtDetails(any()))
                .thenReturn(Result.success(DomainMockProvider.artMock))

            val result = useCase.invoke("tmp")

            assertEquals(DomainMockProvider.artMock, result.getOrNull())
        }
    }

    @Test
    fun `invoke should return failure when repository failure`() {
        runTest {
            val exception = mock<Exception>()

            whenever(artRepository.getArtDetails(any()))
                .thenReturn(Result.failure(exception))

            val result = useCase.invoke("tmp")

            assertEquals(exception, result.exceptionOrNull())
        }
    }
}