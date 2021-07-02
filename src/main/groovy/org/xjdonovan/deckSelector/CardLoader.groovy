package org.xjdonovan.deckSelector

import com.opencsv.CSVReaderBuilder
import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Singleton
@Slf4j
class CardLoader {
    @Transactional
    void loadData() {
        new File('data').listFiles().each {
            loadFile(it)
        }
    }

    void loadFile(File file) {
        log.info "loading ${file.name}"
        def expansion = Expansion.byName(file.name.tokenize('.')[0].toUpperCase())
        file.withReader {
            new CSVReaderBuilder(it).
                withSkipLines(1).
                build().
                readAll().
                each {line ->
                    def card = new Card(
                            name:line[0],
                            cost:line[1].toInteger(),
                            type:CardType.byName(line[2]),
                            expansion:expansion,
                            action:line[3] == "" ? 0 : line[3].toInteger(),
                            buy:line[4] == "" ? 0 : line[4].toInteger(),
                            cards:line[5] == "" ? 0 : line[5].toInteger(),
                            coin:line[6] == "" ? 0 : line[6].toInteger(),
                            gainCard:line[7] == "Y",
                            trash:line[8] == "Y",
                            affectedByCardCount:line[9] == "Y",
                            description:line[10]
                    )
                    if (!card.save()) {
                        log.error("Unable to Save Card ${card.name}: ${card.errors}")
                    }
                }
        }
    }
}
