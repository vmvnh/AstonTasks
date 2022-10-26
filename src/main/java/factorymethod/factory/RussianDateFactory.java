package factorymethod.factory;

import factorymethod.date.Date;
import factorymethod.date.RussianDate;

/**
 * Фабрика российской даты.
 */
public class RussianDateFactory implements DateFactory {

  /**
   * Возвращает сущность российской даты.
   *
   * @return Российская дата.
   */
  @Override
  public Date createDate() {
    return new RussianDate();
  }

  // Переопределение метода для сравнения объектов.
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DateFactory that = (DateFactory) o;
    return this.createDate().getDate().equals(that.createDate().getDate());
  }
}
