package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkWhenArrayIsEmpty() {
        String[] array = new String[]{};
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(array))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empy");
    }

    @Test
    void checkWhenSymbolEqualsNotPresents() {
        String[] array = new String[]{"one:two"};
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(array))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: one:two does not contain the symbol '='");
    }

    @Test
    void checkWhenSymbolIsFirst() {
        String[] array = new String[]{"=one:two"};
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(array))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =one:two does not contain a key");
    }

    @Test
    void checkWhenSymbolIsLast() {
        String[] array = new String[]{"one:two="};
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(array))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: one:two= does not contain a value");
    }
}