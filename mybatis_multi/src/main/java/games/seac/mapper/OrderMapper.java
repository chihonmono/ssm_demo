package games.seac.mapper;

import games.seac.domain.Order;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/12/12 - 10:22
 */
public interface OrderMapper {
    public List<Order> findAll();
}
