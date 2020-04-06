/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmentsoapservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harpreet
 */
@Entity
@Table(name = "LIBRARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Library.findAll", query = "SELECT l FROM Library l"),
    @NamedQuery(name = "Library.findById", query = "SELECT l FROM Library l WHERE l.id = :id"),
    @NamedQuery(name = "Library.findByTitle", query = "SELECT l FROM Library l WHERE l.title = :title"),
    @NamedQuery(name = "Library.findByDescription", query = "SELECT l FROM Library l WHERE l.description = :description"),
    @NamedQuery(name = "Library.findByType", query = "SELECT l FROM Library l WHERE l.type = :type"),
    @NamedQuery(name = "Library.findByCategory", query = "SELECT l FROM Library l WHERE l.category = :category"),
    @NamedQuery(name = "Library.findByDirector", query = "SELECT l FROM Library l WHERE l.director = :director"),
    @NamedQuery(name = "Library.findByCast", query = "SELECT l FROM Library l WHERE l.cast = :cast"),
    @NamedQuery(name = "Library.findByReleasedon", query = "SELECT l FROM Library l WHERE l.releasedon = :releasedon"),
    @NamedQuery(name = "Library.findByRating", query = "SELECT l FROM Library l WHERE l.rating = :rating")})
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 70)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "DIRECTOR")
    private String director;
    @Size(max = 255)
    @Column(name = "CAST")
    private String cast;
    @Lob
    @Column(name = "THUMBNAIL")
    private byte[] thumbnail;
    @Column(name = "RELEASEDON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releasedon;
    @Column(name = "RATING")
    private BigInteger rating;

    public Library() {
    }

    public Library(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getReleasedon() {
        return releasedon;
    }

    public void setReleasedon(Date releasedon) {
        this.releasedon = releasedon;
    }

    public BigInteger getRating() {
        return rating;
    }

    public void setRating(BigInteger rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.assignmentsoapservice.Library[ id=" + id + " ]";
    }
    
}
