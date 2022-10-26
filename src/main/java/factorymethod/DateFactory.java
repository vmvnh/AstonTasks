package factorymethod;

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
