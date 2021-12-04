class Solution {
    
    private static class AccountNameAndEmails {
        String name;
        Set<String> sortedEmails = new TreeSet<>();
        
        private AccountNameAndEmails(String name, Set<String> sortedEmails) {
            this.name = name;
            this.sortedEmails = sortedEmails;
        }
        
        AccountNameAndEmails(List<String> account) {
            Iterator<String> accountIterator = account.iterator();
            this.name = accountIterator.next();
            while (accountIterator.hasNext()) {
                String email = accountIterator.next();
                this.sortedEmails.add(email);
            }
        }
        
        boolean hasSharedEmails(AccountNameAndEmails other) {
            if (!this.name.equals(other.name)) {
                return false;
            }            
            Set<String> intersectSet = new HashSet<>(this.sortedEmails);
            intersectSet.retainAll(other.sortedEmails);
            return intersectSet.size() > 0;
        }

        void mergeAccount(AccountNameAndEmails other) {
            this.sortedEmails.addAll(other.sortedEmails);
        }
        
        List<String> canonicalForm() {
            List<String> account = new ArrayList<>();
            account.add(name);
            for (String email : sortedEmails) {
                account.add(email);
            }
            return account;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<AccountNameAndEmails> accountNamesAndEmails = new ArrayList<>();
        for (List<String> account : accounts) {
            AccountNameAndEmails accountNameAndEmails = new AccountNameAndEmails(account);
            List<AccountNameAndEmails> mergedListOfAccounts = new ArrayList<>();
            for (AccountNameAndEmails prevAccountNameAndEmails : accountNamesAndEmails) {
                if (accountNameAndEmails.hasSharedEmails(prevAccountNameAndEmails)) {
                    accountNameAndEmails.mergeAccount(prevAccountNameAndEmails);
                } else {
                    mergedListOfAccounts.add(prevAccountNameAndEmails);
                }
            }
            mergedListOfAccounts.add(accountNameAndEmails);
            accountNamesAndEmails = mergedListOfAccounts;
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (AccountNameAndEmails accountNameAndEmails : accountNamesAndEmails) {
            mergedAccounts.add(accountNameAndEmails.canonicalForm());
        }
        return mergedAccounts;
    }
}
