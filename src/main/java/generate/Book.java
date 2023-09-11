package generate;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * book
 *
 * @author
 */
@Data
public class Book implements Serializable {
    private Long id;

    private String title;

    private String author;

    private Double price;

    private Date createtime;

    private Date updatetime;

    private static final long serialVersionUID = 1L;
}