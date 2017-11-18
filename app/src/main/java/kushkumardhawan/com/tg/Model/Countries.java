package kushkumardhawan.com.tg.Model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KU854963 on 11/18/2017.
 */

public class Countries implements Serializable {

    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String capital;
    private String region;
    private String subregion;
    private String population;
    private String demonym;
    private String area;
    private String gini;
    private String nativeName;
    private String numericCode;
    private String cioc;
    private String flag;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getGini() {
        return gini;
    }

    public void setGini(String gini) {
        this.gini = gini;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", population='" + population + '\'' +
                ", demonym='" + demonym + '\'' +
                ", area='" + area + '\'' +
                ", gini='" + gini + '\'' +
                ", nativeName='" + nativeName + '\'' +
                ", numericCode='" + numericCode + '\'' +
                ", cioc='" + cioc + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
