package io.github.yashchenkon.date

import java.time.{LocalDate, Period}


/**
  * @author Mykola Yashchenko
  */
object LocalDateExtensions {

  implicit final class LocalDateExt(ext: LocalDate) {
    def +(duration: Period): LocalDate = {
      ext.plus(duration)
    }

    def -(period: Period): LocalDate = {
      ext.minus(period)
    }

    def >(localDate: LocalDate): Boolean = {
      ext.isAfter(localDate)
    }

    def <(localDate: LocalDate): Boolean = {
      ext.isBefore(localDate)
    }

    def ==(localDate: LocalDate): Boolean = {
      localDate.isEqual(localDate)
    }

    def !=(localDate: LocalDate): Boolean = {
      !(ext == localDate)
    }

    def >=(localDate: LocalDate): Boolean = {
      ext > localDate || ext == localDate
    }

    def <=(localDate: LocalDate): Boolean = {
      ext < localDate || ext == localDate
    }
  }

  implicit final class PeriodExt(self: Period) {
    def +(period: Period): Period = {
      self.plus(period)
    }

    def -(period: Period): Period = {
      self.minus(period)
    }

    def fromNow(): LocalDate = {
      LocalDate.now() + self
    }
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
