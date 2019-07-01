package ru.skillbranch.dev_intensive.extensions

import ru.skillbranch.dev_intensive.models.User
import ru.skillbranch.dev_intensive.models.UserView
import ru.skillbranch.dev_intensive.utils.Utils

fun User.toUserView() : UserView {
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null)
                    "Ещё ни разу не заходил"
                else if (isOnline) "online"
                else "Последний раз был ${lastVisit?.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}
