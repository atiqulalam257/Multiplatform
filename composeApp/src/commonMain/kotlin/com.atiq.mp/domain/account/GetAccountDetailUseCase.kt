package com.atiq.mp.domain.account

class GetAccountDetailUseCase(
    private val repository: AccountRepository
) {

    suspend fun execute(): Result<AccountDetail> {
        return repository.getAccountDetail()
    }
}
