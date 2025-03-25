package sebag.florent.domain.usecases

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.repositories.ArtRepository

class GetArtListUseCaseImplTest {

    private lateinit var artRepository: ArtRepository
    private lateinit var useCase: GetArtListUseCase

    @Before
    fun setUp() {
        artRepository = mock()
        useCase = GetArtListUseCaseImpl(artRepository)
    }

    @Test
    fun `invoke should return ArtModel list when repository success`() {
        runTest {
            val artModelMock = mock<List<ArtModel>>()

            whenever(artRepository.getArtCollection()).thenReturn(
                Result.success(artModelMock)
            )

            val result = useCase.invoke(0, 15)

            assertEquals(artModelMock, result.getOrNull())
        }
    }

    @Test
    fun `invoke should return failure when repository failure`() {
        runTest {
            val exception = mock<Exception>()

            whenever(artRepository.getArtCollection())
                .thenReturn(Result.failure(exception))

            val result = useCase.invoke(0, 15)

            assertEquals(exception, result.exceptionOrNull())
        }
    }
}