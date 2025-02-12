package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty();
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotEmpty();
    }

    @Test
    void numberOfVerticesIs4() {
        Box box = new Box(4, 8);
        int result = box.getNumberOfVertices();
        assertThat(result).isGreaterThan(0)
                .isEven()
                .isEqualTo(4);
    }

    @Test
    void numberOfVerticesIs6() {
        Box box = new Box(8, 7);
        int result = box.getNumberOfVertices();
        assertThat(result).isGreaterThan(0)
                .isEven()
                .isEqualTo(8);
    }

    @Test
    void isNotExists() {
        Box box = new Box(4, 0);
        boolean result = box.isExist();
        assertThat(result).isNotNull()
                .isFalse();
    }

    @Test
    void isExists() {
        Box box = new Box(4, 2);
        boolean result = box.isExist();
        assertThat(result).isNotNull()
                .isTrue();
    }

    @Test
    void whenVertexIs8ThanAreaIs96() {
        Box box = new Box(8, 4);
        double result = box.getArea();
        assertThat(result).isGreaterThan(0)
                .isLessThan(100)
                .isEqualTo(96);
    }

    @Test
    void whenVertexIs0ThanAreaIs() {
        Box box = new Box(4, 4);
        double result = box.getArea();
        assertThat(result).isGreaterThan(0)
                .isLessThan(27.72)
                .isCloseTo(27.71d, withPrecision(0.01d));
    }
}