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
  public void printDate() {
    // Формат российской даты дд.мм.гггг
    System.out.println("Актуальная дата: " + day + "." + month + "." + year);
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
