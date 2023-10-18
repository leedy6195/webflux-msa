package dev.oxingaxin.webfluxmsa

interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun searchCustomers(nameFilter: String) : List<Customer>
}