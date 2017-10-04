package io.github.yashchenkon.date

import java.time.{LocalDate, LocalDateTime, LocalTime}

import LocalDateExtensions._
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Mykola Yashchenko
  */
class LocalDateExtensionsTest extends FlatSpec with Matchers {

  it should "add a day" in {
    LocalDate.of(2017, 1, 1) + 1.day should be (LocalDate.of(2017, 1, 2))
  }

  it should "add a week" in {
    LocalDate.of(2017, 1, 1) + 1.week should be (LocalDate.of(2017, 1, 8))
  }

  it should "add a month" in {
    LocalDate.of(2017, 1, 1) + 1.month should be (LocalDate.of(2017, 2, 1))
  }

  it should "add a year" in {
    LocalDate.of(2017, 1, 1) + 1.year should be (LocalDate.of(2018, 1, 1))
  }

  it should "add complex values" in {
    LocalDate.of(2017, 1, 1) + 1.year + 1.day + 1.week + 1.month should be (LocalDate.of(2018, 2, 9))
    LocalDate.of(2017, 1, 1) + (1.year + 1.day + 1.week + 1.month) should be (LocalDate.of(2018, 2, 9))
  }

  it should "remove a day" in {
    LocalDate.of(2017, 1, 2) - 1.day should be (LocalDate.of(2017, 1, 1))
  }

  it should "remove a week" in {
    LocalDate.of(2017, 1, 8) - 1.week should be (LocalDate.of(2017, 1, 1))
  }

  it should "remove a month" in {
    LocalDate.of(2017, 2, 1) - 1.month should be (LocalDate.of(2017, 1, 1))
  }

  it should "remove a year" in {
    LocalDate.of(2018, 1, 1) - 1.year should be (LocalDate.of(2017, 1, 1))
  }

  it should "remove complex values" in {
    LocalDate.of(2018, 2, 9) - 1.year - 1.day - 1.week - 1.month should be (LocalDate.of(2017, 1, 1))
    LocalDate.of(2018, 2, 9) - (1.year + 1.day + 1.week + 1.month) should be (LocalDate.of(2017, 1, 1))
  }

  it should "compare dates" in {
    LocalDate.of(2017, 1, 2) > LocalDate.of(2017, 1, 1) should be (true)
    LocalDate.of(2017, 1, 1) > LocalDate.of(2017, 1, 2) should be (false)
    LocalDate.of(2017, 1, 1) > LocalDate.of(2017, 1, 1) should be (false)

    LocalDate.of(2017, 1, 1) < LocalDate.of(2017, 1, 2) should be (true)
    LocalDate.of(2017, 1, 2) < LocalDate.of(2017, 1, 1) should be (false)
    LocalDate.of(2017, 1, 1) < LocalDate.of(2017, 1, 1) should be (false)

    LocalDate.of(2017, 1, 1) == LocalDate.of(2017, 1, 1) should be (true)
    LocalDate.of(2017, 1, 1) == LocalDate.of(2017, 1, 2) should be (false)

    LocalDate.of(2017, 1, 1) != LocalDate.of(2017, 1, 2) should be (true)
    LocalDate.of(2017, 1, 1) != LocalDate.of(2017, 1, 1) should be (false)

    LocalDate.of(2017, 1, 2) >= LocalDate.of(2017, 1, 1) should be (true)
    LocalDate.of(2017, 1, 1) >= LocalDate.of(2017, 1, 2) should be (false)
    LocalDate.of(2017, 1, 1) >= LocalDate.of(2017, 1, 1) should be (true)

    LocalDate.of(2017, 1, 1) <= LocalDate.of(2017, 1, 2) should be (true)
    LocalDate.of(2017, 1, 2) <= LocalDate.of(2017, 1, 1) should be (false)
    LocalDate.of(2017, 1, 1) <= LocalDate.of(2017, 1, 1) should be (true)
  }

  it should "calculate period from now" in {
    1.day.fromNow should be (LocalDate.now() + 1.day)
  }

  it should "add local time" in {
    LocalDate.of(2017, 1, 1) + LocalTime.of(1, 1) should be (LocalDateTime.of(2017, 1, 1, 1, 1))
  }

}
