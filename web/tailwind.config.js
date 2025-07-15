module.exports = {
    content: [
        "./index.html", "./src/**/*.{js,jsx,ts,tsx}", "./src/components/**/*.{js,jsx,ts,tsx}" // Ensure Tailwind scans your files for class usage
    ],
    theme: {
        extend: {
            borderRadius: {
            },
            colors: {
                'off-off-white': '#FFF2E7D5',
                'light-green-custom': '#FF6D9886',
                'black-custom': '#FF212121'
            },
            spacing: {
            },
        },
    },
    plugins: [],
};