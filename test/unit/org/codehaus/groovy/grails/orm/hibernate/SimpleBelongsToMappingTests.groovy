package org.codehaus.groovy.grails.orm.hibernate

import org.codehaus.groovy.grails.commons.test.AbstractGrailsMockTests

class SimpleBelongsToMappingTests extends AbstractGrailsMockTests {

    void testListMapping() {
        def authorClass = ga.getDomainClass("Author")
        def bookClass = ga.getDomainClass("Book")

        assertEquals "author", authorClass.getPropertyByName("books").otherSide.name
    }

    void onSetUp() {
        gcl.parseClass '''
class Book {
    Long id
    Long version
    Author author
    static belongsTo = [author:Author]
}

class Author {
    Long id
    Long version
    String name
    Set books
    static hasMany = [books:Book]
}
'''
    }
}
