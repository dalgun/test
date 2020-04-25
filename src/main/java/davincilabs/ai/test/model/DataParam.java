package davincilabs.ai.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Dalgun.
 * User: dalgun
 * Date: 2020/04/25
 * Time: 12:18 오후
 */
@Entity
@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataParam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;


}
