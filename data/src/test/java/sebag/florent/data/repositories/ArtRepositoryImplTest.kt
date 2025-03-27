package sebag.florent.data.repositories

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
import retrofit2.HttpException
import sebag.florent.data.entities.ArtListResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity
import sebag.florent.data.mock.DataMockProvider
import sebag.florent.data.repositories.mapper.ArtRepositoryMapper
import sebag.florent.data.source.remote.api.ArtApiService
import sebag.florent.domain.repositories.ArtRepository

@RunWith(MockitoJUnitRunner::class)
class ArtRepositoryImplTest {

    @Mock
    lateinit var mapper: ArtRepositoryMapper

    @Mock
    lateinit var service: ArtApiService

    private lateinit var repository: ArtRepository

    @Before
    fun setUp() {
        repository = ArtRepositoryImpl(service, mapper)
    }

    @Test
    fun `getArtCollection should return ArtModel list when success`() {
        runTest {
            whenever(service.getArtList(any(), any()))
                .thenReturn(DataMockProvider.artListResponseEntityMock)
            whenever(mapper.toModel(any<ArtListResponseEntity>()))
                .thenReturn(DataMockProvider.artListMock)

            val result = repository.getArtList()

            assert(result.isSuccess)
            assertEquals(DataMockProvider.artListMock, result.getOrNull())
        }
    }

    @Test
    fun `getArtCollection should return failure when service failure`() {
        runTest {
            val exception = mock<HttpException>()

            whenever(service.getArtList(any(), any()))
                .thenThrow(exception)

            val result = repository.getArtList()

            assert(result.isFailure)
            assertEquals(exception, result.exceptionOrNull())
        }
    }

    @Test
    fun `getArtDetails should return ArtModel when service success`() {
        runTest {
            whenever(service.getArtDetails(any())).thenReturn(
                DataMockProvider.artDetailResponseEntityMock
            )
            whenever(mapper.toModel(any<ArtObjectResponseEntity>())).thenReturn(
                DataMockProvider.artMock
            )

            val result = repository.getArtDetails("tmp")

            assert(result.isSuccess)
            assertEquals(DataMockProvider.artMock, result.getOrNull())
        }
    }

    @Test
    fun `getArtDetails should return failure when service failure`() {
        runTest {
            val exception = mock<HttpException>()

            whenever(service.getArtDetails(any())).thenThrow(exception)

            val result = repository.getArtDetails("tmp")

            assert(result.isFailure)
            assertEquals(exception, result.exceptionOrNull())
        }
    }

}