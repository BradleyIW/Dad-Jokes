package com.bradley.wilson.jokes

import org.junit.rules.TestRule
import org.mockito.MockitoAnnotations

class InjectMocksRule private constructor() {

    companion object {
        fun create(testClass: Any) = TestRule { statement, _ ->
            statement.also {
                MockitoAnnotations.initMocks(testClass)
            }
        }
    }
}
