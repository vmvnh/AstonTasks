package factorymethod.factory;

import factorymethod.date.Date;

/**
 * Фабрика дат.
 */
public interface DateFactory {

  /**
   * Возвращает сущность даты.
   *
   * @return Сущность даты.
   */
  Date createDate();
}
