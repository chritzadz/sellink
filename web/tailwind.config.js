module.exports = {
    content: [
        "./src/**/*.{js,jsx,ts,tsx}", // Ensure Tailwind scans your files for class usage
    ],
    theme: {
        extend: {
            borderRadius: {
                'md': '0.375rem', // Default for rounded-md
                'lg': '0.5rem',   // Example for rounded-lg
                'xl': '0.75rem',  // Example for rounded-xl
                'full': '9999px', // Example for rounded-full
                'custom': '12px', // Custom radius if needed
            },
            colors: {
                // Add custom colors if needed
                primary: '#1DA1F2',
                secondary: '#14171A',
            },
            spacing: {
                // Customize spacing values if needed
                '18': '4.5rem',
            },
        },
    },
    plugins: [],
};