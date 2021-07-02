package org.xjdonovan.deckSelector

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Bootstrap {
    @Inject
    CardLoader loader

    @EventListener
    void onStartup(StartupEvent event) {
        loader.loadData()
    }
}
