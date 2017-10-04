package io.github.yashchenkon.date

import java.time.{Duration, LocalDate, LocalDateTime, LocalTime}

/**
  * @author Mykola Yashchenko
  */
object LocalTimeExtensions {

  implicit final class LocalTimeExt(self: LocalTime) {
    def +(duration: Duration): LocalTime = {
      self.plus(duration)
    }

    def +(localDate: LocalDate): LocalDateTime = {
      LocalDateTime.of(localDate, self)
    }

    def -(duration: Duration): LocalTime = {
      self.minus(duration)
    }
  }
}
