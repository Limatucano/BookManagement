package br.com.bookmanagement.domain.usecase

import br.com.bookmanagement.data.repository.IBookRepository
import br.com.bookmanagement.domain.mapper.toBooks
import br.com.bookmanagement.domain.model.Books
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ReaderQRCodeUseCase(
    private val repository: IBookRepository
) {

    suspend fun getData(query: String): Flow<Result<Books>> {
        return flow {
            try {
                emit(
                    Result.success(
                        repository.getVolumesByIsbn(query).toBooks()
                    )
                )
            } catch (ex: IOException) {
                emit(Result.failure(ex))
            } catch (ex: HttpException) {
                emit(Result.failure(ex))
            }
        }
    }
}