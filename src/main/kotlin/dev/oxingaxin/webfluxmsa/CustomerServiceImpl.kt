package dev.oxingaxin.webfluxmsa

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservice", Customer.Telephone("+44", "71234566789"))
                )
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]

    override fun searchCustomers(nameFilter: String): List<Customer> =
            customers.filter {
                it.value.name.contains(nameFilter, true)
            }.map(Map.Entry<Int, Customer>::value).toList()
}