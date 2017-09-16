package io.github.yashchenkon.date

import java.time.temporal.TemporalAmount
import java.time.{Duration, LocalDate, LocalDateTime, Period}


/**
  * @author Mykola Yashchenko
  */
object LocalDateTimeExtensions {

  implicit final class LocalDateTimeExt(ext: LocalDateTime) {
    def +(duration: TemporalAmount): LocalDateTime = {
      ext.plus(duration)
    }

    def -(period: TemporalAmount): LocalDateTime = {
      ext.minus(period)
    }

    def >(localDate: LocalDateTime): Boolean = {
      ext.isAfter(localDate)
    }

    def <(localDate: LocalDateTime): Boolean = {
      ext.isBefore(localDate)
    }

    def ==(localDate: LocalDateTime): Boolean = {
      localDate.isEqual(localDate)
    }

    def !=(localDate: LocalDateTime): Boolean = {
      !(ext == localDate)
    }

    def >=(localDate: LocalDateTime): Boolean = {
      ext > localDate || ext == localDate
    }

    def <=(localDate: LocalDateTime): Boolean = {
      ext < localDate || ext == localDate
    }
  }

  implicit final class DurationExt(self: Duration) {
    def +(period: Duration): Duration = {
      self.plus(period)
    }

    def -(period: Duration): Duration = {
      self.minus(period)
    }

    def fromNow(): LocalDateTime = {
      LocalDateTime.now() + self
    }
  }

  implicit final class PeriodExt(self: Period) {
    def +(period: Period): Period = {
      self.plus(period)
    }

    def -(period: Period): Period = {
      self.minus(period)
    }

    def fromNow(): LocalDateTime = {
      LocalDateTime.now() + self
    }
  }

  implicit final class Second(s: Int) {
    def second: Duration = Duration.ofSeconds(s)
  }

  implicit final class Hour(h: Int) {
    def hour: Duration = Duration.ofHours(h)
  }

  implicit final class Day(d: Int) {
    def day: Period = Period.ofDays(d)
  }

  implicit final class Month(m: Int) {
    def month: Period = Period.ofMonths(m)
  }

  implicit final class Week(w: Int) {
    def week: Period = Period.ofWeeks(w)
  }

  implicit final class Year(y: Int) {
    def year: Period = Period.ofYears(y)
  }
}
