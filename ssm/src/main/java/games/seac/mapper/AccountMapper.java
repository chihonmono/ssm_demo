package games.seac.mapper;

import games.seac.domain.Account;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/15 - 11:05
 */
public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();
}
