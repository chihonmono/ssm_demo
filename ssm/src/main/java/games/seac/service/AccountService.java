package games.seac.service;

import games.seac.domain.Account;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/15 - 11:07
 */
public interface AccountService {
    public void save(Account account);

    public List<Account> findAll();
}
