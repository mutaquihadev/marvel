package com.mutaquiha.marvel.commons

abstract class BaseMapper<IN, OUT> {
    abstract fun transform(entity: IN): OUT
}