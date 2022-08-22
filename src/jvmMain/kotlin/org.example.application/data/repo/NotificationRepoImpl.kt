package org.example.application.data.repo

import kotlinx.coroutines.flow.Flow
import org.example.application.domain.repos.NotificationRepo

class NotificationRepoImpl: NotificationRepo {
    override fun notifyUser(userId: Long, message: String) {
        TODO("Not yet implemented")
    }

    override fun getNotifications(): Flow<String> {
        TODO("Not yet implemented")
    }

}