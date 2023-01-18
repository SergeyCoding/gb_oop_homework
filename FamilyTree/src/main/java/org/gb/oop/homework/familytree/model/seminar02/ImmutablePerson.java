package org.gb.oop.homework.familytree.model.seminar02;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования
 * Описать неизменяемый класс (Неизменяемость должна сохранятся при любых обстоятельствах)
 * <p>
 * Должен быть объявлен как final, чтобы от него нельзя было наследоваться.
 * Иначе дочерние классы могут нарушить иммутабельность.
 * <p>
 * Все поля класса должны быть приватными в соответствии с принципами инкапсуляции.
 * <p>
 * Для корректного создания экземпляра в нем должны быть параметризованные конструкторы,
 * через которые осуществляется первоначальная инициализация полей класса.
 * <p>
 * Для исключения возможности изменения состояния после инстанцирования, в классе не должно быть сеттеров.
 * <p>
 * Для полей-коллекций необходимо делать глубокие копии, чтобы гарантировать их неизменность.
 */
public final class ImmutablePerson {
    private final String name;
    private final LocalDate birthday;
    private final Map<String, String> specialSigns = HashMap.newHashMap(0);


    public ImmutablePerson(String name, LocalDate birthday, Map<String, String> specialSigns) {
        this.name = name;
        this.birthday = birthday;
        
        for (String key : specialSigns.keySet()) {
            this.specialSigns.put(key, specialSigns.get(key));
        }
    }

    public ImmutablePerson(String name, LocalDate birthday) {
        this(name, birthday, HashMap.newHashMap(0));
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Особые приметы
     */
    public Map<String, String> getSpecialSigns() {
        Map<String, String> deepCopy = new HashMap<String, String>();
        for (String key : specialSigns.keySet()) {
            deepCopy.put(key, specialSigns.get(key));
        }
        return deepCopy;
    }
}
