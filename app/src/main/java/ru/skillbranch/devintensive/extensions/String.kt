package ru.skillbranch.devintensive.extensions

fun String.truncate(count: Int = 16) : String {
    val processedString = this.trim()
    if (processedString.length <= count + 1)
        return processedString
    return processedString.substring(0, count + 1).trim() + "..."
}

fun String.stripHtml() : String {
    return this.replace("<[^<]*?>|&#\\d+;".toRegex(), "").replace("\\s+".toRegex(), " ")
}