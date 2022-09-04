package com.maandraj.core.domain


interface IUseCase  {
    interface SingleIn<in Input> : IUseCase {
        suspend operator fun invoke(data: Input)
    }
    interface SingleInOut<in Input, out Output> : IUseCase {
        suspend operator fun invoke(data: Input): Output
    }
    interface Out<out Output> : IUseCase {
        suspend operator fun invoke(): Output
    }
}