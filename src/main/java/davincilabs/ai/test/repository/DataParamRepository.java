package davincilabs.ai.test.repository;

import davincilabs.ai.test.model.DataParam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dalgun.
 * User: dalgun
 * Date: 2020/04/25
 * Time: 12:21 오후
 */
public interface DataParamRepository extends JpaRepository<DataParam, Long> {
}
