package io.github.yashchenkon.date

import java.time.{LocalDate, LocalDateTime}

import io.github.yashchenkon.date.LocalDateTimeExtensions._
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Mykola Yashchenko
  */
class LocalDateTimeExtensionsTest extends FlatSpec with Matchers {

  it should "add a day" in {
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) + 1.day should be (LocalDateTime.of(2017, 1, 2, 1, 1, 1))
  }

  it should "add a week" in {
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) + 1.week should be (LocalDateTime.of(2017, 1, 8, 1, 1, 1))
  }

  it should "add a month" in {
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) + 1.month should be (LocalDateTime.of(2017, 2, 1, 1, 1, 1))
  }

  it should "add a year" in {
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) + 1.year should be (LocalDateTime.of(2018, 1, 1, 1, 1, 1))
  }

  it should "add complex values" in {
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) + 1.year + 1.day + 1.week + 1.month should be (LocalDateTime.of(2018, 2, 9, 1, 1, 1))
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) + (1.year + 1.day + 1.week + 1.month) should be (LocalDateTime.of(2018, 2, 9, 1, 1, 1))
  }

  it should "remove a day" in {
    LocalDateTime.of(2017, 1, 2, 1, 1, 1) - 1.day should be (LocalDateTime.of(2017, 1, 1, 1, 1, 1))
  }

  it should "remove a week" in {
    LocalDateTime.of(2017, 1, 8, 1, 1, 1) - 1.week should be (LocalDateTime.of(2017, 1, 1, 1, 1, 1))
  }

  it should "remove a month" in {
    LocalDateTime.of(2017, 2, 1, 1, 1, 1) - 1.month should be (LocalDateTime.of(2017, 1, 1, 1, 1, 1))
  }

  it should "remove a year" in {
    LocalDateTime.of(2018, 1, 1, 1, 1, 1) - 1.year should be (LocalDateTime.of(2017, 1, 1, 1, 1, 1))
  }

  it should "remove complex values" in {
    LocalDateTime.of(2018, 2, 9, 1, 1, 1) - 1.year - 1.day - 1.week - 1.month should be (LocalDateTime.of(2017, 1, 1, 1, 1, 1))
    LocalDateTime.of(2018, 2, 9, 1, 1, 1) - (1.year + 1.day + 1.week + 1.month) should be (LocalDateTime.of(2017, 1, 1, 1, 1, 1))
  }

  it should "compare dates" in {
    LocalDateTime.of(2017, 1, 2, 1, 1, 1) > LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (true)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) > LocalDateTime.of(2017, 1, 2, 1, 1, 1) should be (false)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) > LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (false)

    LocalDateTime.of(2017, 1, 1, 1, 1, 1) < LocalDateTime.of(2017, 1, 2, 1, 1, 1) should be (true)
    LocalDateTime.of(2017, 1, 2, 1, 1, 1) < LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (false)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) < LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (false)

    LocalDateTime.of(2017, 1, 1, 1, 1, 1) == LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (true)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) == LocalDateTime.of(2017, 1, 2, 1, 1, 1) should be (false)

    LocalDateTime.of(2017, 1, 1, 1, 1, 1) != LocalDateTime.of(2017, 1, 2, 1, 1, 1) should be (true)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) != LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (false)

    LocalDateTime.of(2017, 1, 2, 1, 1, 1) >= LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (true)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) >= LocalDateTime.of(2017, 1, 2, 1, 1, 1) should be (false)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) >= LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (true)

    LocalDateTime.of(2017, 1, 1, 1, 1, 1) <= LocalDateTime.of(2017, 1, 2, 1, 1, 1) should be (true)
    LocalDateTime.of(2017, 1, 2, 1, 1, 1) <= LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (false)
    LocalDateTime.of(2017, 1, 1, 1, 1, 1) <= LocalDateTime.of(2017, 1, 1, 1, 1, 1) should be (true)
  }
}
