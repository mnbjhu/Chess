package org.example.application.domain.repos

import kotlinx.coroutines.flow.Flow

interface NotificationRepo {
    fun notifyUser(userId: Long, message: String)
    fun getNotifications(): Flow<String>
}