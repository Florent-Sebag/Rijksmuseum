package sebag.florent.data.repositories.mapper

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import sebag.florent.data.mock.DataMockProvider

class ArtRepositoryMapperImplTest {

    private lateinit var mapper: ArtRepositoryMapper

    @Before
    fun setUp() {
        mapper = ArtRepositoryMapperImpl()
    }

    @Test
    fun `toModel should map ArtObjectResponseEntity to ArtModel`() {

        val result = mapper.toModel(DataMockProvider.artObjectResponseEntityMock)

        assertEquals(DataMockProvider.artMock, result)
    }

    @Test
    fun `toModel should map ArtCollectionResponseEntity to List of ArtModel`() {

        val result = mapper.toModel(DataMockProvider.artListResponseEntityMock)

        assertEquals(DataMockProvider.artListMock, result)
    }
}