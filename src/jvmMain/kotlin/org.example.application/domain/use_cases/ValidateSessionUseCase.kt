package org.example.application.domain.use_cases

import org.example.application.data.repo.UserRepoImpl
import org.example.application.domain.repos.UserRepo

class ValidateSessionUseCase(val repo: UserRepo = UserRepoImpl()) {
}