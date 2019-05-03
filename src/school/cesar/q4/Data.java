package school.cesar.q4;

import java.util.Arrays;

/**
 * Created by OtacilioN on 02/05/19.
 */
public class Data {
    private int dia, mes, ano;
    private diaDaSemanaEnum diaDaSemana;

    public enum diaDaSemanaEnum {
        SEG(0), TER(1), QUAR(2), QUI(3), SEX(4), SAB(5), DOM(6);

        private Integer dayOfWeek;

        diaDaSemanaEnum(int day) {
            this.dayOfWeek = day;
        }

        public boolean isLowerThan(diaDaSemanaEnum other) {
            return this.dayOfWeek < other.dayOfWeek;
        }
        public boolean isGreaterThan(diaDaSemanaEnum other) {
            return this.dayOfWeek > other.dayOfWeek;
        }
    }


    // TODO Remove magical numbers
    public Data(int dia, int mes, int ano, diaDaSemanaEnum diaDaSemana) {
        final int maxFevDay = 29;
        final int january = 1;
        final int february = 2;
        final int december = 12;
        final int mesesCom30Dias[] = {4, 6, 9, 11};
        final int maxMonthDaysLower = 30;
        final int maxMonthDaysHigher = 31;
        if(mes < january)
            mes = january;
        if(mes > december)
            mes = december;
        if(mes == february){
            if(dia > maxFevDay){
                dia = maxFevDay;
            }
        }
        if(dia < 1)
            dia = 1;

        else if(Arrays.asList(mesesCom30Dias).contains(mes)){
            if(dia > maxMonthDaysLower)
                dia = maxMonthDaysLower;
        }
        else{
            if(dia > maxMonthDaysHigher);
                dia = maxMonthDaysHigher;
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.diaDaSemana = diaDaSemana;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public diaDaSemanaEnum getDiaDaSemana() {
        return diaDaSemana;
    }

    public String compareDates(Data date){
        if(date.getAno() > this.ano){
            return "maior";
        }
        if(date.getAno() < this.ano){
            return "menor";
        }

        if(date.getMes() > this.mes){
            return "maior";
        }
        if(date.getMes() < this.mes){
            return "menor";
        }

        if(this.getDia() > this.dia){
            return "maior";
        }
        if(this.getDia() < this.dia){
            return "menor";
        }
        return "igual";
    }

    public String compareDates(diaDaSemanaEnum diaDaSemanaCompare){
        if(this.diaDaSemana.isLowerThan(diaDaSemanaCompare)){
            return "antes";
        }
        if(this.diaDaSemana.isGreaterThan(diaDaSemanaCompare)){
            return "depois";
        }
        return "igual";
    }

    public static void main(String[] args) {
        Data date1 = new Data(0, 13, 2017, diaDaSemanaEnum.SEG);
        Data date2 = new Data(1, 12, 2017, diaDaSemanaEnum.TER);
        Data date3 = new Data(30, 2, 2017, diaDaSemanaEnum.QUAR);
        Data date4 = new Data(31, 2, 2017, diaDaSemanaEnum.QUI);
        Data date5 = new Data(28, 2, 2017, diaDaSemanaEnum.SEX);

        System.out.println(date1.compareDates(date2));
        System.out.println(date1.compareDates(date3));
        System.out.println(date4.compareDates(date4));
        System.out.println(date4.compareDates(date5));
        System.out.println(date3.compareDates(diaDaSemanaEnum.SEG));

    }
}
