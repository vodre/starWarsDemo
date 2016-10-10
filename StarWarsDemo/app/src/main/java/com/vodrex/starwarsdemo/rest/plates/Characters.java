package com.vodrex.starwarsdemo.rest.plates;

/**
 * Created by vodrex on 10/9/16.
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Generated("org.jsonschema2pojo")
public class Characters {

    private Integer count;
    private String next;
    private Object previous;
    private List<Character> results = new ArrayList<Character>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Characters() {
    }

    /**
     *
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public Characters(Integer count, String next, Object previous, List<Character> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The next
     */
    public String getNext() {
        return next;
    }

    /**
     *
     * @param next
     * The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     *
     * @return
     * The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     * The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     * The results
     */
    public List<Character> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Character> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
