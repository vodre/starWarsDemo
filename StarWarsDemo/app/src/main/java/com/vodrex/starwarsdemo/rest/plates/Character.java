package com.vodrex.starwarsdemo.rest.plates;

/**
 * Created by vodrex on 10/9/16.
 */


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Character {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private List<String> films = new ArrayList<String>();
    private List<String> species = new ArrayList<String>();
    private List<String> vehicles = new ArrayList<String>();
    private List<String> starships = new ArrayList<String>();
    private String created;
    private String edited;
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Character() {
    }

    /**
     *
     * @param edited
     * @param starships
     * @param birthYear
     * @param species
     * @param films
     * @param hairColor
     * @param skinColor
     * @param url
     * @param mass
     * @param height
     * @param created
     * @param eyeColor
     * @param name
     * @param gender
     * @param homeworld
     * @param vehicles
     */
    public Character(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeworld, List<String> films, List<String> species, List<String> vehicles, List<String> starships, String created, String edited, String url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The height
     */
    public String getHeight() {
        return height;
    }

    /**
     *
     * @param height
     *     The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     *
     * @return
     *     The mass
     */
    public String getMass() {
        return mass;
    }

    /**
     *
     * @param mass
     *     The mass
     */
    public void setMass(String mass) {
        this.mass = mass;
    }

    /**
     *
     * @return
     *     The hairColor
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     *
     * @param hairColor
     *     The hair_color
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     *
     * @return
     *     The skinColor
     */
    public String getSkinColor() {
        return skinColor;
    }

    /**
     *
     * @param skinColor
     *     The skin_color
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     *
     * @return
     *     The eyeColor
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     *
     * @param eyeColor
     *     The eye_color
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     *
     * @return
     *     The birthYear
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     *
     * @param birthYear
     *     The birth_year
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    /**
     *
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     *     The homeworld
     */
    public String getHomeworld() {
        return homeworld;
    }

    /**
     *
     * @param homeworld
     *     The homeworld
     */
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    /**
     *
     * @return
     *     The films
     */
    public List<String> getFilms() {
        return films;
    }

    /**
     *
     * @param films
     *     The films
     */
    public void setFilms(List<String> films) {
        this.films = films;
    }

    /**
     *
     * @return
     *     The species
     */
    public List<String> getSpecies() {
        return species;
    }

    /**
     *
     * @param species
     *     The species
     */
    public void setSpecies(List<String> species) {
        this.species = species;
    }

    /**
     *
     * @return
     *     The vehicles
     */
    public List<String> getVehicles() {
        return vehicles;
    }

    /**
     *
     * @param vehicles
     *     The vehicles
     */
    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @return
     *     The starships
     */
    public List<String> getStarships() {
        return starships;
    }

    /**
     *
     * @param starships
     *     The starships
     */
    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    /**
     *
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     *     The edited
     */
    public String getEdited() {
        return edited;
    }

    /**
     *
     * @param edited
     *     The edited
     */
    public void setEdited(String edited) {
        this.edited = edited;
    }

    /**
     *
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
