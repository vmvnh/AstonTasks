package factorymethod;

import java.time.LocalDate;

/**
 * Российский формат даты.
 */
public class RussianDate implements Date {
  int day, month, year;

  /**
   * Вывод актуальной даты.
   */
  @Override
  public String getDate() {
    // Формат российской даты дд.мм.гггг
    return day + "." + month + "." + year;
  }

  // Переопределение метода для сравнения объектов.
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Date that = (Date) o;
    return this.getDate().equals(that.getDate());
  }

  /**
   * Конструктор класса.
   */
  public RussianDate() {
    LocalDate date = LocalDate.now();
    this.day = date.getDayOfMonth();
    this.month = date.getMonthValue();
    this.year = date.getYear();
  }
}
