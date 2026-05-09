package LibraryManagmentSystem;

public enum BookStatus {

    AVAILABLE {
        @Override
        public boolean canCheckOut() {
            return true;
        }

        @Override
        public String action() {
            return "Checked out successfully.";
        }
    },

    CHECKED_OUT {
        @Override
        public boolean canCheckOut() {
            return false;
        }

        @Override
        public String action() {
            return "Sorry, book is already checked out.";
        }
    },

    RESERVED {
        @Override
        public boolean canCheckOut() {
            return false;
        }

        @Override
        public String action() {
            return "Book is reserved — cannot check out directly.";
        }
    },

    DAMAGED {
        @Override
        public boolean canCheckOut() {
            return false;
        }

        @Override
        public String action() {
            return "Book is damaged and not available for checkout.";
        }
    };



    public abstract boolean canCheckOut();
    public abstract String action();
}
