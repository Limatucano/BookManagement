package br.com.bookmanagement.domain.mapper

import br.com.bookmanagement.data.remote.model.BookDto
import br.com.bookmanagement.data.remote.model.BooksDto
import br.com.bookmanagement.data.remote.model.ImageLinkDto
import br.com.bookmanagement.data.remote.model.IndustryIdentifierDto
import br.com.bookmanagement.data.remote.model.VolumeInfoDto
import br.com.bookmanagement.domain.model.Book
import br.com.bookmanagement.domain.model.Books
import br.com.bookmanagement.domain.model.ImageLink
import br.com.bookmanagement.domain.model.IndustryIdentifier
import br.com.bookmanagement.domain.model.VolumeInfo

fun BooksDto?.toBooks(): Books {
    return Books(
        totalItems = this?.totalItems.handleOptional(),
        items = this?.items?.map { it.toBook() }.orEmpty()
    )
}

fun BookDto?.toBook(): Book {
    return Book(
        kind = this?.kind.handleOptional(),
        id = this?.id.handleOptional(),
        volumeInfo = this?.volumeInfo.toVolumeInfo()
    )
}

fun VolumeInfoDto?.toVolumeInfo(): VolumeInfo {
    return VolumeInfo(
        title = this?.title.handleOptional(),
        subtitle = this?.subtitle.handleOptional(),
        authors = this?.authors.orEmpty(),
        publishedDate = this?.publishedDate.handleOptional(),
        description = this?.description.handleOptional(),
        industryIdentifiers = this?.industryIdentifiers?.map { it.toIndustryIdentifier() }.orEmpty(),
        pageCount = this?.pageCount.handleOptional(),
        categories = this?.categories.orEmpty(),
        averageRating = this?.averageRating.handleOptional(),
        imageLinks = this?.imageLinks.toImageLink(),
        language = this?.language.handleOptional()
    )
}

fun IndustryIdentifierDto?.toIndustryIdentifier(): IndustryIdentifier {
    return IndustryIdentifier(
        type = this?.type.handleOptional(),
        identifier = this?.identifier.handleOptional()
    )
}

fun ImageLinkDto?.toImageLink(): ImageLink {
    return ImageLink(
        smallThumbnail = this?.smallThumbnail.handleOptional(),
        thumbnail = this?.thumbnail.handleOptional()
    )
}

fun String?.handleOptional() = this ?: ""
fun Float?.handleOptional() = this ?: 0f
fun Int?.handleOptional() = this ?: 0