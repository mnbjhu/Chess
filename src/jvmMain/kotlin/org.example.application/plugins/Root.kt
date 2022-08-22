package org.example.application.plugins

import io.ktor.server.application.*
import org.example.application.data.repo.UserRepoImpl
import org.example.application.domain.repos.UserRepo

fun Application.installPlugins(repo: UserRepo = UserRepoImpl()) {
    installAuth(repo)
    installJson()
    installWebSockets()
}