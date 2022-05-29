package com.example.plugins

import authorizedRoute
import com.example.domain.repository.UserDataSource
import com.example.routes.getUserInfoRoute
import com.example.routes.tokenVerificationRoute
import com.example.routes.unauthorizedRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject
import rootRoute

fun Application.configureRouting() {

    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)
        rootRoute()
        tokenVerificationRoute(application, userDataSource)
        getUserInfoRoute(application, userDataSource)
        authorizedRoute()
        unauthorizedRoute()
    }
}