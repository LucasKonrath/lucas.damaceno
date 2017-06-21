package br.com.crescer.lista01;

import static br.com.crescer.lista01.CalendarUtils.DiaSemana.DOMINGO;
import static br.com.crescer.lista01.CalendarUtils.DiaSemana.QUARTA_FEIRA;
import static br.com.crescer.lista01.CalendarUtils.DiaSemana.QUINTA_FEIRA;
import static br.com.crescer.lista01.CalendarUtils.DiaSemana.SABADO;
import static br.com.crescer.lista01.CalendarUtils.DiaSemana.SEGUNDA_FEIRA;
import static br.com.crescer.lista01.CalendarUtils.DiaSemana.SEXTA_FEIRA;
import static br.com.crescer.lista01.CalendarUtils.DiaSemana.TERCA_FEIRA;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author carloshenrique
 */
public class CalendarUtilsTest {

    private final CalendarUtils calendarUtils = new ManipulaDatas();
    private static final Calendar CALENDAR = Calendar.getInstance();

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_Domingo() {
        CALENDAR.set(2017, 5, 18, 0, 0, 0); // 2017-06-18 00:00:00

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(DOMINGO, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_SegundaFeira() {
        CALENDAR.set(2017, 5, 19, 0, 0, 0); // 2017-06-19 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(SEGUNDA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_TercaFeira() {
        CALENDAR.set(2017, 5, 20, 0, 0, 0); // 2017-06-20 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(TERCA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuartaFeira() {
        CALENDAR.set(2017, 5, 21, 0, 0, 0); // 2017-06-21 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(QUARTA_FEIRA, diaSemana);
    }

    /**
     * Test of diaSemana method, of class CalendarUtils.
     */
    @Test
    public void testDiaSemana_QuintaFeira() {
        CALENDAR.set(2017, 5, 22, 0, 0, 0); // 2017-06-22 00:00:00    

        final CalendarUtils.DiaSemana diaSemana = calendarUtils.diaSemana(CALENDAR.getTime());

        assertEquals(QUINTA_FEIRA, diaSemana);
    }
}